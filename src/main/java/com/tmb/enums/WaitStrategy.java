package com.tmb.enums;

/**
 * Enums to restrict the users to choose an appropriate waiting strategy before operating an element.
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 * @see com.tmb.factories.ExplicitWaitFactory
 * @see com.tmb.pages.BasePage
 */
public enum WaitStrategy {
	
	CLICKABLE,
	PRESENCE,
	VISIBLE,
	NONE
}
