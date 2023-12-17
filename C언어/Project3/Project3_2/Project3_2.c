#define _CRT_SECURE_NO_WARNINGS //scanf_s가 아닌 scanf를 사용하면 에러가 난다. 이것을 이용하면 scanf를 사용할 수 있다. 에러를 무시하는 역할을 한다.
#include <stdio.h> //#include 는 전처리기이며 옆에 있는 것을 포함한다는 뜻이다. stdio는 standard input output의 약자이며 h는 header의 약자이다. stdio.h는 내가 작성하고 있는 소스 코드에 표준 입출력에 관련한 헤더파일이다.

void main(void) //main()은 프로그램의 엔트리 포인트이고 운영체제가 실행시켜 주는 함수이다. int 는 함수가 종료될 때 정수형 값을 리턴해야 한다.
{
    int number; //정수형으로 number라는 이름을 가진 변수를 선언한다.

    printf("정수를 입력하세요: "); //어떤 변수를 입력해야 하는지 사용자에게 알려준다.
    scanf("%d", &number); //number를 입력받는다.

    if (number % 7 == 0 && number % 2 != 0) // 입력된 수가 7의 배수이면서 홀수인지 확인
        printf("입력된 %d는 7의 배수이며 홀수입니다.\n", number);
   
    else if (number % 7 != 0 && number% 2 != 0) // 입력된 수가 7의 배수가 아니면서 홀수인지 확인
        printf("입력된 %d는 7의 배수가 아니며 홀수입니다.\n", number);

    else if (number % 7 == 0 && number % 2 == 0) // 입력된 수가 7의 배수이면서 짝수인지 확인
        printf("입력된 %d는 7의 배수이며 짝수입니다.\n", number);

    else if (number % 7 != 0 && number % 2 == 0) // 입력된 수가 7의 배수가 아니면서 짝수인지 확인
        printf("입력된 %d는 7의 배수가 아니며 짝수입니다.\n", number);
}