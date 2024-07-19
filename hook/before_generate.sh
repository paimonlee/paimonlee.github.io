#!/bin/bash 
echo "Do something before generate blog....."

git clone https://github.com/thomasyu929/hexo-theme-peomas.git --depth 1 themes/peomas 
sed -i -e "s/landscape/peomas/g" _config.yml
sed -i -e "s/mark: Peomas/mark: Paimonlee/g" themes/peomas/_config.yml


echo "Done"