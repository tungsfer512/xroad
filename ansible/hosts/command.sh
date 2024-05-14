lxc delete xroad-cs-1 xroad-cs-2 xroad-cp xroad-ca xroad-ss-manage-1 xroad-ss-manage-2 xroad-ss-1-1 xroad-ss-1-2 xroad-ss-2-1 xroad-ss-2-2

lxc stop --all -f

ansible-playbook -i /home/ubuntu/Desktop/kc-thaibinh/xroad/ansible/hosts/xroad_hosts.ini /home/ubuntu/Desktop/kc-thaibinh/xroad/ansible/xroad_init_local.yml -vvvv