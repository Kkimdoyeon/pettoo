#define _CRT_SECURE_NO_WARNINGS //scanf_s가 아닌 scanf를 사용하면 에러가 난다. 이것을 이용하면 scanf를 사용할 수 있다. 에러를 무시하는 역할을 한다.
#include <stdio.h>//#include 는 전처리기이며 옆에 있는 것을 포함한다는 뜻이다. stdio는 standard input output의 약자이며 h는 header의 약자이다. stdio.h는 내가 작성하고 있는 소스 코드에 표준 입출력에 관련한 헤더파일이다.
#include <stdlib.h>//C 언어의 표준 라이브러리로, 문자열 변환, 의사 난수 생성, 동적 메모리 관리 등의 함수들을 포함하고 있다

// (1) 연봉을 입력 받는 함수
int getIncome() {
    int income; //연봉액
    printf("첫 연봉을 입력하세요(만원 단위): ");
    scanf("%d", &income); //첫 연봉액 입력 받음
    return income; //입력 받은 연봉액 반환
}

// (2) 매년 물가 인상률을 계산하는 함수
float getRate() {
    int randomPercentage = rand() % 5 + 1; // 1부터 5까지의 랜덤 정수 생성
    float inflationRate = (float)randomPercentage / 100 + 1; //퍼센티지로 계산해야 하므로 실수형으로 선언 뒤 100을 나눈 후 1을 더해줌
    return inflationRate; //물가 인상률 반환
}

// (3) 올해 연봉을 계산하는 함수
int calcIncome(int income, float incRate) { 
    return (int)(income * incRate); //연봉액에 연봉 인상률을 곱하여 인상된 연봉액수를 반환
}

void main(void) {
    int income = 0; //연봉액
    int sumIncome = 0; //연봉 합계
    float incRate; //매년 연봉 인상률
    int year = 30; // 30년간의 연봉 계산 횟수

    income = getIncome(); // (1) 연봉을 입력 받음

    for (int i = 0; i < year; i++) {
        incRate = getRate(); //매년 연봉 인상률 계산
        if (year == 0) //첫 해일 때
            income = getIncome(); //첫해의 연봉은 키보드로 입력 받음
        else //2번째 해부터 연봉을 년도별로 계산함
            income = calcIncome(income, incRate); //물가 인상률을 반영한 인상된 연봉액 계산
        printf("%d년차의 연봉액은 %d만원\n", i + 1, income); //해당 햇수와 그해 연봉액 계산
        sumIncome += income; //총 연봉, 평균 연봉 계산을 위하여
    }

    // 결과 출력
    printf("\n30년간 받은 총 연봉: %d만원\n", sumIncome);
    printf("연간 평균 연봉: %d만원\n", sumIncome / year);
}