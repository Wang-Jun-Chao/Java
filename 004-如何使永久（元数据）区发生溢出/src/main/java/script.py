import csv
import math


def read_data(csv_file_path, skip_first_line=False):
    """
    读取csv谁的中的数据
    :param csv_file_path: csv文件路径，可以传绝对路径地址
    :param skip_first_line: 是否忽略第一行，默认忽略
    :return: 返回结果{ "2018-04-22": ["123", "345, "136"]}
    """
    result = {}
    with open(csv_file_path, "r", encoding="utf-8") as csv_file:
        # 读取csv文件，返回的是迭代类型
        cvs_read = csv.reader(csv_file)

        if skip_first_line is True:
            skip_first_line = 1
        else:
            skip_first_line = 0

        for i, line in enumerate(cvs_read):
            if (i >= skip_first_line):
                result[line[0]] = line[1:]
    return result


def write_data(csv_file_path, header, data):
    """
    写csv文件数据
    :param csv_file_path: csv文件路径，可以传绝对路径地址
    :param header: 第一行数据["A", "B", "C"]
    :param data: 写余下行数据[["1", "2", "3"],["5", "6", "8"]]
    :return: 无返回值
    """
    with open(csv_file_path, "w", newline="", encoding="utf-8") as csv_file:
        # dialect为打开csv文件的方式，默认是excel，delimiter="\t"参数指写入的时候的分隔符
        csv_writer = csv.writer(csv_file, dialect=("excel"))
        # csv文件插入一行数据，把下面列表中的每一项放入一个单元格（可以用循环插入多行）
        csv_writer.writerow(header)
        for line in data:
            csv_writer.writerow(line)


def compare_data(a, b):
    """
    数据比较
    :param a: 数据格式：{ "2018-04-22": ["123", "345, "136"], "2018-04-23": ["123", "345, "136"]}
    :param b: 数据格式：{ "2018-04-22": ["123", "345, "136"], "2018-04-23": ["123", "345, "136"]}
    :return: 数据格式：[["1", "2", "3"],["5", "6", "8"]]
    """
    result = []

    a_keys = a.keys()
    b_keys = b.keys()

    a_diff = [v for v in a_keys if v not in b]
    b_diff = [v for v in b_keys if v not in a]

    inter = [v for v in a_keys if v in b_keys]

    # result.append(["A ∩ B"])
    # res = 0
    for key in inter:
        temp = [key]
        all_zero = True
        for i in range(len(a[key])):
            if math.isclose(float(a[key][i]), float(b[key][i])):
                temp.append("0")
            else:
                all_zero = False
                temp.append(a[key][i] + "<>" + b[key][i])
        if all_zero is False:
            result.append(temp)

    # result.append(["A - B"])
    append_data(a, a_diff, result, False)
    # result.append(["B - A"])
    append_data(b, b_diff, result, True)

    return result


def append_data(a, keys, result, before=False):
    """
    向result中添加数据
    :param a: 数据格式：{ "2018-04-22": ["123", "345, "136"]}
    :param keys: 数据格式："2018-04-22"
    :param result: [["123", "345, "136"], ["123", "345, "136"]]
    :param before: True："0<>"添加在每个元素前，False："<>0"添加添加在每个元素后，<>表表示等于
    :return:
    """
    for key in keys:
        temp = [key]
        all_zero = True
        for i in a[key]:
            # 如果是空字符串就添加空字符串
            if i is None or i.strip() == "":
                temp.append("")
                continue
            # 如果是0就要需要添加0
            elif math.isclose(float(i), 0):
                temp.append("0")
                continue

            all_zero = False

            # 如果不为0就根据需要在前后进行添加操作
            if before:
                temp.append("0<>" + i)
            else:
                temp.append(i + "<>0")
        if all_zero is False:
            result.append(temp)


def read_line(csv_file_path, line_num=0):
    """
    从csv文件中读取指定行
    :param csv_file_path: csv文件路径，可以传绝对路径地址
    :param line_num: 指定行
    :return: 
    """
    with open(csv_file_path, "r", encoding="utf-8") as csv_file:
        # 读取csv文件，返回的是迭代类型
        cvs_read = csv.reader(csv_file)
        result = []
        for i, line in enumerate(cvs_read):
            if i == line_num:
                result = line
    return result


def sort_data(data):
    """
    排序操作
    :param data: 待排序的数据，数据格式：[["2018-04-23", "123", "345, "136"], ["2018-04-22", "123", "345, "136"]]
    :return: 排序后的数组，按时间升序
    """
    return sorted(data, key=lambda line: line[0])


a_data = read_data("a.csv", True)
b_data = read_data("b.csv", True)
header = read_line("a.csv", 0)
result = compare_data(a_data, b_data)
result = sort_data(result)
write_data("result.csv", header, result)
