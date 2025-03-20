package com.weather.informer.constants;

/***************************************************************
 * CONDITIONS FOR CASH COVER TO BUY:
 * 
 * Buy to Cover is used to close an existing short position.
 * 
 * CASH COVER BUY applies in two cases:
 * 1. Margin Account:
 *    - Open: Short sell (Margin)
 *    - Close: Cash Cover Buy
 * 
 * 2. Cash Account (Naked Options):
 *    - Open: Cash naked option
 *    - Close: Cash Cover Buy
 * 
 * --------------------------------------------------------------
 * HYBRID & CMA ACCOUNTS:
 * 
 * - CMA Account's cash/margin portions identified using:
 *     TBBMAACT.CMA_CSH_MGN_CD
 *       'C' → Cash portion
 *       'M' → Margin portion
 * 
 * - Position Table (TBHBCCPS):
 *     AC_CSH_MGN_PRT_IN = 'C' → Cash portion → Eligible for Cash Cover Buy
 * 
 * --------------------------------------------------------------
 * ACCOUNT TYPE INDICATORS:
 * 
 * 07 B4-I-ACCOUNT-TYPE PIC X(1)
 *  - '1' → Cash Account
 *  - '2' → Margin Account
 *  - '5' → CMA Account
 *  - Others: Commodity, Custodian, Retirement, Trust Accounts
 * 
 * POWER CURVE FIELD:
 *  B6-0-BH-CMA-CASH-MARGIN-IND
 *    - '0' → Cash Account → ACT-CMA-CSH-MGN-CD = 'C'
 *    - Else → Margin Account → ACT-CMA-CSH-MGN-CD = 'M'
 * 
 * --------------------------------------------------------------
 * SHORT POSITION INDICATOR:
 * 
 * TBHBCCPS.CPS-PS-LG-SH-IN = 'S' → Short position flag
 * 
 * If CPS-PS-LG-SH-IN = 'S':
 *   - WS-FW-LONG-QUANTITY = 0
 *   - WS-FW-SHORT-QY holds short quantity
 * 
 * If Cash Short Qty = 0 → No short position → Cash Cover Buy not triggered.
 * 
 * Reference: Margin close sell logic (BMAPCR04-Margin-Close)
 * 
 ***************************************************************/


/***************************************************************
 * CONDITIONS FOR MARGIN COVER BUY:
 * 
 * Margin Cover Buy is used to close short positions using margin funds.
 * 
 * MARGIN COVER BUY applies primarily in Margin accounts:
 * 
 * 1. Margin Account:
 *    - Open: Short sell (Margin)
 *    - Close: Margin Cover Buy
 * 
 * --------------------------------------------------------------
 * HYBRID & CMA ACCOUNTS:
 * 
 * - For CMA Accounts:
 *   - Use TBBMAACT.CMA_CSH_MGN_CD to differentiate:
 *       'M' → Margin portion eligible for Margin Cover Buy
 * 
 * - Position Table (TBHBCCPS):
 *   - AC_CSH_MGN_PRT_IN = 'M' → Indicates margin portion used
 *   - Only positions with AC_CSH_MGN_PRT_IN = 'M' should trigger Margin Cover Buy.
 * 
 * --------------------------------------------------------------
 * ACCOUNT TYPE INDICATORS:
 * 
 * 07 B4-I-ACCOUNT-TYPE PIC X(1)
 *  - '2' → Margin Account
 *  - '5' → CMA Account (margin portion)
 * 
 * POWER CURVE FIELD:
 *  B6-0-BH-CMA-CASH-MARGIN-IND
 *    - Not '0' → Margin Account → ACT-CMA-CSH-MGN-CD = 'M'
 * 
 * --------------------------------------------------------------
 * SHORT POSITION IDENTIFICATION:
 * 
 * TBHBCCPS.CPS-PS-LG-SH-IN = 'S' → Indicates a short position.
 * 
 * If CPS-PS-LG-SH-IN = 'S':
 *   - WS-FW-LONG-QUANTITY = 0
 *   - WS-FW-SHORT-QY holds short quantity.
 * 
 * Only if short quantity > 0, Margin Cover Buy is triggered.
 * 
 * --------------------------------------------------------------
 * SUMMARY FLOW:
 * 
 * 1. Check Account Type:
 *    - Margin or CMA (Margin portion).
 * 
 * 2. For CMA Accounts:
 *    - Verify CMA_CSH_MGN_CD = 'M'.
 *    - Position record should have AC_CSH_MGN_PRT_IN = 'M'.
 * 
 * 3. Confirm Short Position:
 *    - CPS-PS-LG-SH-IN = 'S'.
 *    - Short Quantity > 0.
 * 
 * Reference: Margin close sell logic (BMAPCR04-Margin-Close)
 * 
 ***************************************************************/



public interface WeatherConstants {

	// view resolver prefix and suffix
	String VIEW_PREFIX = "/WEB-INF/views/";
	String VIEW_SUFFIX = ".jsp";

	// End points:
	String GET_WEATHER_INFO = "/getWeatherInfoByCities/{cities}";

	// Open weather url
	String OPEN_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?APPID=7bf825562208478a0ea322b942c87030&q=";

}
