num = "901231-1914983"
age = int(num[0]) * 10 + int(num[1])


if(num[7] == "1"):
    gender = "남자"
else:
    gender = "여자"

print(age,"년생", gender)