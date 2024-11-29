package org.example;


import io.qameta.allure.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Owner ("Volha Zhukouskaya")
public class MainTest {

    int a = 63;
    int b = 21;

    int sumResult = 84;
    int minusResult = 42;
    int multiplyResult = 1323;
    int divideResult = 3;

    int wrongSumResult = 45;
    int wrongMinusResult = 4;
    int wrongMultiplyResult = 13;
    int wrongDivideResult = 31;

    @Epic("Арифметические операции")
    @Feature("Сложение")
    @Story ("Верный ожидаемый результат")
    @Description ("Сложение с верным ожидаемым результатом")
    @Link ("https://allurereport.org/docs/gettingstarted-readability/#description-links-and-other-metadata")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testSum() {
        assertEquals(sumResult, a + b);
    }
    @Epic("Арифметические операции")
    @Feature("Сложение")
    @Story ("Неверный ожидаемый результат")
    @Description ("Сложение с неверным ожидаемым результатом")
    @Issue("Ошибка в тесте: неверный ожидаемый результат")
    @Link ("https://allurereport.org/docs/gettingstarted-readability/#description-links-and-other-metadata")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void wrongTestSum() {
        assertEquals(wrongSumResult, a + b);
    }
    @Epic("Арифметические операции")
    @Feature("Вычитание")
    @Story ("Верный ожидаемый результат")
    @Description ("Вычитание с верным ожидаемым результатом")
    @Link ("https://allurereport.org/docs/gettingstarted-readability/#description-links-and-other-metadata")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testMinus() {
        assertEquals(minusResult, a - b);
    }
    @Epic("Арифметические операции")
    @Feature("Вычитание")
    @Story ("Неверный ожидаемый результат")
    @Description ("Вычитание с неверным ожидаемым результатом")
    @Issue("Ошибка в тесте: неверный ожидаемый результат")
    @Link ("https://allurereport.org/docs/gettingstarted-readability/#description-links-and-other-metadata")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void wrongTestMinus() {
        assertEquals(wrongMinusResult, a - b);
    }
    @Epic("Арифметические операции")
    @Feature("Умножение")
    @Story ("Верный ожидаемый результат")
    @Description ("Умножение с верным ожидаемым результатом")
    @Link ("https://allurereport.org/docs/gettingstarted-readability/#description-links-and-other-metadata")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testMultiply() {
        assertEquals(multiplyResult, a * b);
    }
    @Epic("Арифметические операции")
    @Feature("Умножение")
    @Story ("Неверный ожидаемый результат")
    @Description ("Умножение с неверным ожидаемым результатом")
    @Issue("Ошибка в тесте: неверный ожидаемый результат")
    @Link ("https://allurereport.org/docs/gettingstarted-readability/#description-links-and-other-metadata")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void wrongTestMultiply() {
        assertEquals(wrongMultiplyResult, a * b);
    }
    @Epic("Арифметические операции")
    @Feature("Деление")
    @Story ("Верный ожидаемый результат")
    @Story ("Верный ожидаемый результат")
    @Description ("Деление с верным ожидаемым результатом")
    @Link ("https://allurereport.org/docs/gettingstarted-readability/#description-links-and-other-metadata")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testDivide() {
        assertEquals(divideResult, a / b);
    }
    @Epic("Арифметические операции")
    @Feature("Деление")
    @Story ("Неверный ожидаемый результат")
    @Description ("Деление с неверным ожидаемым результатом")
    @Issue("Ошибка в тесте: неверный ожидаемый результат")
    @Link ("https://allurereport.org/docs/gettingstarted-readability/#description-links-and-other-metadata")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void wrongTestDivide() {
        assertEquals(wrongDivideResult, a / b);
    }

}

