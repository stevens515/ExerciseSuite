#!/bin/bash

# This script is used to download some images and packaged kubernetes used

KUBEVERSION=$1

images=(kube-proxy-amd64:$KUBEVERSION kube-discovery-amd64:1.0 kubedns-amd64:1.7 kube-scheduler-amd64:$KUBEVERSION kube-controller-manager-amd64:$KUBEVERSION kube-apiserver-amd64:$KUBEVERSION etcd-amd64:3.0.14-kubeadm kube-dnsmasq-amd64:1.3 exechealthz-amd64:1.1 pause-amd64:3.0 kubernetes-dashboard-amd64:v1.5.0)

echo -e "\033[33mclean old files!\033[0m"
rm -rf ~/kube_images > /dev/null 2>&1
rm -f ~/kube_images-$KUBEVERSION.tar.gz > /dev/null 2>&1

echo -e "\033[32mcreate download directory...\033[0m"
mkdir ~/kube_images

for imageName in ${images[@]} ; do
  echo -e "\033[32mpull image: $imageName...\033[0m"
  docker pull gcr.io/google_containers/$imageName
  if [ ! "$?"=="0" ]; then
    echo -e "\033[31merror: pull image: $imageName failed!\033[0m"
    exit 1
  fi
  echo -e "\033[32msave image: $imageName...\033[0m"
  docker save gcr.io/google_containers/$imageName > ~/kube_images/$imageName.tar

  if [ -f ~/kube_images/$imageName.tar ]; then
    echo -e "\033[32mdownload $imageName image success!\033[0m"
  else
    echo -e "\033[31mdownload $imageName image failed!\033[0m"
    exit 1
  fi
done

echo -e "\033[32mcreate images package...\033[0m"
(cd ~/kube_images && tar -zcvf ~/kube_images-$KUBEVERSION.tar.gz *.tar)

if [ -f ~/kube_images-$KUBEVERSION.tar.gz ]; then
  echo -e "\033[32mcreate images package success!\033[0m"
  echo -e "\033[32mclean temp files...\033[0m"
  rm -rf ~/kube_images
else
  echo -e "\033[31merror: create images package failed!\033[0m"
  exit 1
fi
