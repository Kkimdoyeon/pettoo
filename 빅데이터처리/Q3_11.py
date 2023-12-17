str = input("5개의 성적을 입력하세요(각 값은 공백으로 분리): ")

grade = str.split()
grade = [int(grade) for grade in grade]
grade.sort()

print(grade)