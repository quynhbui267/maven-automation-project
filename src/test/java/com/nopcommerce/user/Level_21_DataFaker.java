package com.nopcommerce.user;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

import commons.BaseTest;

public class Level_21_DataFaker extends BaseTest {

	public static void main(String[] args) {
		Faker faker = new Faker();
		System.out.println(faker.name().firstName());
		System.out.println(faker.finance().creditCard(CreditCardType.MASTERCARD));
		System.out.println(getRandomNumberByDateTime());
	}
}
