import datetime
import sys
import os
import smtplib
import time

import subprocess
from email.mime.text import MIMEText
from email.utils import formataddr





def excuteCommand(com):
    ex = subprocess.Popen(com, stdout=subprocess.PIPE, shell=True)
    out, err = ex.communicate()
    status = ex.wait()
    print("cmd in:", com)
    print("cmd out: ", out.decode())
    return out.decode()



def send_email(send_to, send_message, send_from, password):
    ret = True
    if type(send_to) is str:
        send_to = [send_to]
    try:
        msg = MIMEText(send_message, 'plain', 'utf-8')
        msg['From'] = formataddr(["System Monitor", send_from])  
        msg['To'] = formataddr(["to", ";".join(send_to)])  
        msg['Subject'] = "System Log" 

        server = smtplib.SMTP_SSL("smtp.qq.com", 465)  
        server.login(send_from, password)  
        server.sendmail(send_from, send_to, msg.as_string())  
        server.quit()  
    except Exception:  
        ret = False
    return ret


def run_forever(track_names, to, sfrom, password):
    while True:
        message = str(datetime.datetime.now()) + ": \n"
        message += "# docker ps: \n"
        # Check docker ps status
        docker_ps = excuteCommand('docker ps')
        message += docker_ps + "\n-------------------------------------------------\n\n"

        # Check backend process
        message += "track " + str(track_list) + "in (#docker ps): \n"
        for pid in track_names:
            message += f"track {pid} in (docker ps) : {bool(pid in docker_ps)} .\n"
            if pid not in docker_ps:
                message += f"Found that {pid} not in (docker ps) please manually check server log.\n"
                result=send_email(to, message, sfrom, password) 
                if result:
                    print("Sent")
                else:
                    print("Fail to send")
                continue
        # Check per hour
        time.sleep(3600)

if __name__ == '__main__':
    track_list = [
        "studymama",
        "kibana",
        "logstash",
        "mysqldb",
        "neo4j",
    ]

    sender = '1494157048@qq.com'
    sender_pass = 'ulzxiofnetsofedb'
    send_to = ['liyexyy@gmail.com','1494157048@qq.com']
    run_forever(track_list, send_to, sender, sender_pass)



