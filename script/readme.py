import os
import numpy as np

# 获取数据项
path = '../Hot100'
dirlist = os.listdir(path)

print(dirlist)

# 转化为数据项格式
l = []
for k in dirlist:
    t = k.split(' ')
    t[0] = int(t[0])
    l.append(tuple(t))
dt = np.dtype([('no',  int), ('title',  'O')])
arr = np.array(l, dtype=dt)
arr = np.sort(arr, order='no')
print(arr)


def Gen_markdown_table_2d(data: np.array, head_names: tuple, ):
    table = ''
    
    # 表头
    head = '|{}|\n'.format('|'.join(head_names))
    table += head
    
    # 分界线
    split = '|{}|\n'.format('|'.join('-'*len(head_names)))
    table += split
    
    # 数据项
    for item in data:
        # 序号、标题
        info = '|'.join('%s' % id for id in list(item.tolist()))
        
        # 解法链接
        path = '../Hot100/' + str(item[0]) + ' ' + item[1]
        dl = os.listdir(path)
        links = []
        for f in dl:
            if os.path.isdir(path + '/' + f):
                if f == 'cpp':
                    links.append('[C++]' + '(https://github.com/hakaryzhang36/Leetcode/Hot100/' + str(item[0]) + '%' + item[1]  + '/cpp)')
                if f == 'py':
                    links.append('[Python]' + '(https://github.com/hakaryzhang36/Leetcode/Hot100/' + str(
                        item[0]) + '%' + item[1] + '/py)')
        sol = ','.join(links)

        line = '|{}|\n'.format('|'.join([info, sol]))
        table += line
    return table

table = Gen_markdown_table_2d(arr, ('#', 'Title', 'Solution'))
print(table)

os.rename('../README.md', '../README.txt')
md = open('../README.txt', 'w')

l = '# LeetCode\n**LeetCode Algorithm Problems\' Solution List**\n'
md.write(l)
md.write(table)
md.close()

os.rename('../README.txt', '../README.md')
