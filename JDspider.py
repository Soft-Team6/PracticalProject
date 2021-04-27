import requests
from selenium import webdriver
import time
from bs4 import BeautifulSoup
import csv
import lxml.html

def get_page(html):
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.85 Safari/537.36'
    }
    source = requests.get(html, headers=headers).content.decode('UTF-8')
    #     print(source)
    selector = lxml.html.fromstring(source)
    return selector


def spider(html):
    # 排名
    rank_list=[]
    for i in range(10):
        rank_list.append(i+1)
    print(rank_list)
    # 书名
    name = html.xpath('//div[@class="p-name"]/a/em/text()').extract_first()
    name_list = []
    for item in name:
        name_list.append(item)
    print(name_list)
    # 价格
    price = html.xpath('//div[@class="p-price"]/strong/i/text()')
    price_list = []
    for item in price:
        price_list.append(item)
    print(price_list)

    # 出版社
    public=html.xpath('//div[@class="p-shopnum"]/a/text()')
    public_list=[]
    for item in public:
        public_list.append(item)
    print(public_list)

    # 以字典形式保存至列表
    result_list=[]
    for i in range(10):
        result={'排名':rank_list[i],'书名':name_list[i],'价格':price_list[i],'出版社':public_list[i]}
        result_list.append(result)

    return result_list

def write_file(result_list):
    with open('Top10.csv', 'w', newline='', encoding='GBK') as f:
        writer = csv.DictWriter(f, fieldnames=['排名', '书名', '价格', '出版社'])
        writer.writeheader()
        writer.writerows(result_list)

url = 'https://search.jd.com/Search?keyword=%E7%BC%96%E7%A8%8B%E4%B9%A6%E7%B1%8D&suggest=1.his.0.0&wq=%E7%BC%96%E7%A8%8B%E4%B9%A6%E7%B1%8D&psort=3&click=0'
html = get_page(url)
# print(html)
result_list = spider(html)
# print(result_list)
write_file(result_list)
