# CA
lxc config device add ca ca8888 proxy listen=tcp:0.0.0.0:8889 connect=tcp:10.108.252.122:8888
# CS
lxc config device add cs cs4000 proxy listen=tcp:0.0.0.0:4000 connect=tcp:10.108.252.78:4000
# SSM1
lxc config device add ssm1 ssm14000 proxy listen=tcp:0.0.0.0:4009 connect=tcp:10.108.252.216:4000
lxc config device add ssm1 ssm1443 proxy listen=tcp:0.0.0.0:9443 connect=tcp:10.108.252.216:443
# SS1
lxc config device add ss1 ss14000 proxy listen=tcp:0.0.0.0:4001 connect=tcp:10.108.252.134:4000
lxc config device add ss1 ss1443 proxy listen=tcp:0.0.0.0:1443 connect=tcp:10.108.252.134:443
# SS2
lxc config device add ss2 ss24000 proxy listen=tcp:0.0.0.0:4002 connect=tcp:10.108.252.152:4000
lxc config device add ss2 ss2443 proxy listen=tcp:0.0.0.0:2443 connect=tcp:10.108.252.152:443
