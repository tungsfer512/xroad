#!/bin/bash
set -e
# all groups
XG="xroad-security-officer,xroad-registration-officer,xroad-service-administrator,xroad-system-administrator,xroad-securityserver-observer"
# cluster slave node compatible groups
SG="xroad-security-officer,xroad-securityserver-observer"

node_type=$(crudini --get '/etc/xroad/conf.d/node.ini' node type 2>/dev/null || echo standalone)

UG=""
if [[ "$node_type" == "slave" ]]; then
    UG=$SG
else
    UG=$XG
fi

if [ "$1x" = "x" ]
then
    cat << EOF
Usage: $0 <username>
Create local X-Road admin user <username> and add the user to the following groups:
EOF
    echo " ${UG//,/$'\n' }"
    exit 1
fi

#
# add X-road groups
#
for groupname in ${UG//,/$' '}
do
    if ! getent group $groupname > /dev/null; then
        groupadd --system $groupname
    fi
done

#
# proxy-ui uses PAM password (pam_unix) authentication by default
# make /etc/shadow readable by group 'shadow'
#
if ! getent group shadow >/dev/null; then
    groupadd --system shadow
fi

if ! sudo -u xroad test -r /etc/shadow; then
    echo "Note. Making /etc/shadow readable by the group 'shadow'"
    chgrp shadow /etc/shadow
    chmod g+r /etc/shadow
    usermod -a -G shadow xroad || true
fi

if getent passwd "$1" >/dev/null
then
    echo "User $1 exists, just adding to the xroad groups"
    usermod -a -G $UG "$1"
else
    echo "Adding user $1"
    useradd "$1" -c "X-Road admin user" -G $UG
    passwd "$1"
fi

