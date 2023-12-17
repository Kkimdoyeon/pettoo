file_name = input()

try:
    with open(file_name, 'r') as file:
        file_content = file.read()

    uppercase_content = file_content.upper()

    with open('output.txt', 'w') as output_file:
        output_file.write(uppercase_content)
    
except FileNotFoundError:
    print(f'파일 {file_name}을(를) 찾을 수 없습니다.')