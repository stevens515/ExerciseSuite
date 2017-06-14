#/bin/bash

yum install rpm-sign -y 

# clean old files
#rm -f /data/repo/centos/7/x86_64/{kubelet*,kubeadm*,kubernetes-cni*,kubectl*}

# signature rpms
echo %_signature gpg > ~/.rpmmacros
echo "%_gpg_name mritd (mritd rpm repository)" >> ~/.rpmmacros

for rpmName in `ls ~/git_projects/adm_release/rpm/output/x86_64/*.rpm`; do
  rpm --addsign $rpmName
  cp -f $rpmName /data/repo/centos/7/x86_64
done

# create repodata
`pwd`/flush_repo.sh

# sync cdn
`pwd`/syncrpm.sh
