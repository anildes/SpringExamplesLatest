package com.weather.informer.utils;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

public class HttpErrorHandler extends DefaultResponseErrorHandler {

/*|Power Curve Physical Data Model                   |Data Element                           |Data element Value         |as-is Rule Field                 |PowerCurve Input vs Output  |PC Data Type          |PC Length             |
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|OCONTROL                                          |ALIAS                                  |CMMNFLOW                   |                                 |                            |                      |                      |
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|OCONTROL                                          |SIGNATURE                              |BrokAuth                   |                                 |                            |                      |                      |
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|Statelr                                           |FLOW                                   |CM12IntradayTradeTotal_TP  |                                 |                            |                      |                      |
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|Stateln                                           |dataSources                            |CM12IntradayTradeTotal_TP  |                                 |                            |                      |                      |
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|CommonProcessRequestln.CM12IntradayTradeTotal_TP  |IsExecStockOptionExerciseIndicator     |Y'or'N                     |DTL-EXSOP-EXR-IN (TBBMADTL)      |Input                       |String                |1.0                   |
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|CommonProcessRequestln.CM12IntradayTradeTotal TP  |baRequestTypeCode                      |                           |DTL-BA-RQTY-CD (TBBMADTL)        |Input                       |String                |2.0                   |
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|CommonProcessRequestln.CM12IntradayTradeTotal_TP  |baTransactionRequirementAmount         |                           |DTL-BA-TR-RQ-AM (TBBMADTL)       |Input                       |Decimal               |20.0                  |
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|CommonProcessRequestIn.CM12IntradayTradeTotal TP  |baOnline Trade RetentionReleaseAmount  |                           |DTL-BA-OT-RTN-RLS-AM (TBBMADTL)  |Input                       |Decimal               |20.0                  |
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|CommonProcessResponseOut.CM12IntradayTotals       |ba12SellTotal                          |                           |BA12-O-SELL-TOTAL                |Output                      |Decimal               |20.0                  |
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|CommonProcessResponseOut.CM12IntradayTotals       |ba12BuyTotal                           |                           |BA12-O-BUY-TOTAL                 |Output                      |Decimal               |20.0                  |
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|CommonProcessResponseOut.CM12IntradayTotals       |ba12MaintentanceTota                   |                           |BA12-O-MAINTENTANCE-TOTAL        |Output                      |Decimal               |20.0                  |
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
|CommonProcessResponseOut.CM12IntradayTotals       |ba12RegulationTTotal                   |                           |BA12-O-REGT-TOTAL                |Output                      |Decimal               |20.0                  |
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/




	
	private static final Logger LOG = LogManager.getLogger(HttpErrorHandler.class);

	@Override
	public void handleError(ClientHttpResponse httpResponse) throws IOException {
		super.handleError(httpResponse);
		LOG.warn("Error @ Handling http request :: Status ::  "+httpResponse.getStatusText());
		
	}


}
