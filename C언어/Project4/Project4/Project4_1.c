#define _CRT_SECURE_NO_WARNINGS //scanf_s�� �ƴ� scanf�� ����ϸ� ������ ����. �̰��� �̿��ϸ� scanf�� ����� �� �ִ�. ������ �����ϴ� ������ �Ѵ�.
#include <stdio.h>//#include �� ��ó�����̸� ���� �ִ� ���� �����Ѵٴ� ���̴�. stdio�� standard input output�� �����̸� h�� header�� �����̴�. stdio.h�� ���� �ۼ��ϰ� �ִ� �ҽ� �ڵ忡 ǥ�� ����¿� ������ ��������̴�.
#include <stdlib.h>//C ����� ǥ�� ���̺귯����, ���ڿ� ��ȯ, �ǻ� ���� ����, ���� �޸� ���� ���� �Լ����� �����ϰ� �ִ�

// (1) ������ �Է� �޴� �Լ�
int getIncome() {
    int income; //������
    printf("ù ������ �Է��ϼ���(���� ����): ");
    scanf("%d", &income); //ù ������ �Է� ����
    return income; //�Է� ���� ������ ��ȯ
}

// (2) �ų� ���� �λ���� ����ϴ� �Լ�
float getRate() {
    int randomPercentage = rand() % 5 + 1; // 1���� 5������ ���� ���� ����
    float inflationRate = (float)randomPercentage / 100 + 1; //�ۼ�Ƽ���� ����ؾ� �ϹǷ� �Ǽ������� ���� �� 100�� ���� �� 1�� ������
    return inflationRate; //���� �λ�� ��ȯ
}

// (3) ���� ������ ����ϴ� �Լ�
int calcIncome(int income, float incRate) { 
    return (int)(income * incRate); //�����׿� ���� �λ���� ���Ͽ� �λ�� �����׼��� ��ȯ
}

void main(void) {
    int income = 0; //������
    int sumIncome = 0; //���� �հ�
    float incRate; //�ų� ���� �λ��
    int year = 30; // 30�Ⱓ�� ���� ��� Ƚ��

    income = getIncome(); // (1) ������ �Է� ����

    for (int i = 0; i < year; i++) {
        incRate = getRate(); //�ų� ���� �λ�� ���
        if (year == 0) //ù ���� ��
            income = getIncome(); //ù���� ������ Ű����� �Է� ����
        else //2��° �غ��� ������ �⵵���� �����
            income = calcIncome(income, incRate); //���� �λ���� �ݿ��� �λ�� ������ ���
        printf("%d������ �������� %d����\n", i + 1, income); //�ش� �޼��� ���� ������ ���
        sumIncome += income; //�� ����, ��� ���� ����� ���Ͽ�
    }

    // ��� ���
    printf("\n30�Ⱓ ���� �� ����: %d����\n", sumIncome);
    printf("���� ��� ����: %d����\n", sumIncome / year);
}