FROM nginx:latest

# 初期セットアップで反映するファイルをコピー
COPY ./nginx.conf /etc/nginx/conf.d/app.conf
CMD /usr/sbin/nginx -g 'daemon off;' -c /etc/nginx/nginx.conf