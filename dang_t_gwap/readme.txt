1.��Ŀ����
  ģ�⵱�������ֹ���.���߹���ϵͳ(��������)
 (1)��Ʒ���ģ��(main)
    ������,����������
 (2)���ﳵģ��(cart)
    ���,��������,ɾ��,�ָ�����,���ͳ�Ƶ�
 (3)�û�ģ��(user)
    ��¼,ע��
 (4)����ģ��(order)
    ��������-->ȷ��,��д�ͻ���ַ,�ɹ���ʾ
2.��Ŀ�����ܹ�
  �������MVC˼��,ʵ�ֲַ����
  (1)��ʾ��(V)
     JSP,jQuery,Ajax,Struts2��ǩ+OGNL���ʽ
  (2)���Ʋ�(C)
     Struts2������,struts.xml����
  (3)ҵ���(M)
     Action���
  (4)���ݷ��ʲ�(M)
     DAO���,JDBC����
3.��Ŀ�ļ��Ľṹ
  (1)srcĿ¼�ṹ
    com.tarena.action
    com.tarena.action.main ��Ʒ���Action
    com.tarena.action.cart ���ﳵAction
    com.tarena.action.order ����Action
    com.tarena.action.user �û�ģ��Action
    com.tarena.dao DAO�ӿ�
    com.tarena.dao.impl DAOʵ��
    com.tarena.util ������
    com.tarena.interceptor ���������
    com.tarena.entity ʵ����
    com.tarena.service �������ӿ�
    com.tarena.service.impl �ӿ�ʵ��
  (2)Web-Root�ļ�Ŀ¼
     /Web-Root/user/    �û�ģ��JSP
     /Web-Root/cart/    ���ﳵJSP
     /Web-Root/order/   ����JSP
     /Web-Root/main/    ��Ʒ���JSP
     /Web-Root/common/  ҳüҳ�ŵȹ���JSP
     /Web-Root/css/     ��ʽ�ļ�
     /Web-Root/js/      javascript�ű�
     /Web-Root/images/  ����ͼƬ
     /Web-Root/productImages/ ��ƷͼƬ
   (3)�����ļ�
      a.struts�����ļ�
        struts.xml       ϵͳ������
        struts-user.xml  �û�ģ��
        struts-main.xml  ��Ʒ���ģ��
        struts-order.xml ����ģ��
        struts-cart.xml  ���ﳵģ��
       b.web.xml
         ����Struts2������
4.���ݿ����
  (1)d_user:�û���Ϣ��
  (2)d_product:��Ʒ��Ϣ��
  (3)d_book:ͼ����Ϣ��
  (4)d_category:�����Ϣ
  (5)d_category_product:���Ͳ�Ʒ��Ӧ��ϵ
  (6)d_order:������Ϣ��
  (7)d_item:������ϸ��,�洢��ĳ������������Щ��Ʒ
  (8)d_receive_address:�ͻ���ַ��

5.����jar��
  struts2���İ�
  ���ݿ�����
  struts2-json-plugin.jar


�ҵĹ��ﳵ��http://localhost:8080/T-GWAP/cart/cart_list.jsp
ҳ��1��http://localhost:8080/T-GWAP/common/foot.jsp
ҳ��2��http://localhost:8080/T-GWAP/common/foot1.jsp
ҳü1��http://localhost:8080/T-GWAP/common/head.jsp
ҳü2��http://localhost:8080/T-GWAP/common/head1.jsp
���ܣ�http://localhost:8080/T-GWAP/common/introduce.jsp
��ַ������js��js/address_form.js
�Ŵ�js��js/jqzoom.js
��¼��js��js/login_form.js
ע���js��js/register_form.js
��֤��js��js/verify_form.js
�鼮��ϸ��http://localhost:8080/T-GWAP/main/book_info.jsp
��ҳ��http://localhost:8080/T-GWAP/main/main.jsp
�鼮���ࣺhttp://localhost:8080/T-GWAP/main/book_list.jsp
���http://localhost:8080/T-GWAP/main/category.jsp
������http://localhost:8080/T-GWAP/main/hot.jsp
���飺http://localhost:8080/T-GWAP/main/new.jsp
�Ƽ���http://localhost:8080/T-GWAP/main/recommend.jsp
��ַ����http://localhost:8080/T-GWAP/order/address_form.jsp
������Ϣ��http://localhost:8080/T-GWAP/order/order_info.jsp
�����ɹ���http://localhost:8080/T-GWAP/order/order_ok.jsp
����ҳ�棺http://localhost:8080/T-GWAP/user/help.jsp
��½ҳ�棺http://localhost:8080/T-GWAP/user/login_form.jsp
ע��ҳ�棺http://localhost:8080/T-GWAP/user/register_form.jsp
��֤ҳ�棺http://localhost:8080/T-GWAP/user/verify_form.jsp
������֤��ͨ����http://localhost:8080/T-GWAP/user/register_ok.jsp
����http://localhost:8080/T-GWAP/error.jsp
����ҳ�棺http://localhost:8080/T-GWAP/index.jsp