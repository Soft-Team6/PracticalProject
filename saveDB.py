import pymysql
import csv

def opmysql(data):  # 插入数据库
    table = 'JDBook'
    keys = ', '.join(data.keys())
    values = ', '.join(['%s'] * len(data))
    sql = 'INSERT INTO {table}({keys}) VALUES ({values})'.format(table=table, keys=keys, values=values)
    try:
        cursor.execute(sql, tuple(data.values()))
        connectPool.commit()
        print('插入成功')
    except:
        connectPool.ping(True)

# 连接数据库
connectPool = pymysql.connect(host="localhost", user="root", password="123456", database="jdbook", charset="utf8")
cursor = connectPool.cursor()

def read_csv():
    with open('Top10.csv', 'r', encoding='utf-8') as f:
        reader = csv.reader(f)
        head_row = next(reader)
        booklist = []
        for item in reader:
            bookdict = {}
            bookdict['id'] = int(item[0])
            bookdict['name'] = item[1]
            bookdict['price'] = float(item[2])
            bookdict['public'] = item[3]
            booklist.append(bookdict)
        print(booklist)
        return booklist

booklist = read_csv()
for item in booklist:
    opmysql(item)
