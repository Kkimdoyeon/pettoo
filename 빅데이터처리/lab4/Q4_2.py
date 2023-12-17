file_name = input("파일 이름을 입력하세요: ")

try:
    with open(file_name, 'r') as file:
        total_confidence = 0  
        count = 0  
        
        for line in file:
            if line.startswith('X-DSPAM-Confidence:'):
                confidence = float(line.split(':')[1])
                total_confidence += confidence
                count += 1

        if count > 0:
            average_confidence = total_confidence / count
            print(f'평균: {average_confidence:.12f}')
        else:
            print('파일에 Confidence 값이 없습니다.')

except FileNotFoundError:
    print('파일을 찾을 수 없습니다.')
except Exception as e:
    print(f'오류가 발생했습니다: {e}')