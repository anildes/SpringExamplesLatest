FROM openjdk:8-jre-slim

# Set the working directory
WORKDIR /app

# Copy the packaged JAR file into the container
COPY *.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]


private Cm12IntradayNonTradeTotalNP buildCM12IntradayNonTradeTotal_NP(
    CommonTechRuleResult commonTechRuleResult,
    RulesExecutionEntity<CashCommonRulesRequest, CashCommonRulesResponse> entity,
    TradeValidateRequest tradeValidateRequest
) {
    Cm12IntradayNonTradeTotalNP cm12IntradayTradeTotal_NP = new Cm12IntradayNonTradeTotalNP();
    
    Map<String, ExecutionPayload> payloads = ((PowerCurveRulesExecutionEntity) entity).getPayloads();

    // Extract and process payload
    Optional.ofNullable(payloads.get(TaskType.TBAMBNVA.getId()))
        .filter(executionPayload -> ExecutionStatus.SUCCEEDED.equals(executionPayload.getStatus()))
        .map(executionPayload -> ((TaskPayload) executionPayload).getCashManagementAccountActivities())
        .filter(payloadList -> payloadList != null && !payloadList.isEmpty())
        .ifPresent(payloadList -> {
            TBAMBNVA firstPayload = payloadList.get(0); // Extract first element
            cm12IntradayTradeTotal_NP.setAmaIntradayDelayedPayoutAdjustmentAmount(
                safeDouble(firstPayload.getAma_idy_dlpy_aj_am())
            );
            cm12IntradayTradeTotal_NP.setAmfsIntradayPendingCreditAmount(
                safeDouble(firstPayload.getAmaah_ipe_pndcr_am())
            );
            cm12IntradayTradeTotal_NP.setAmaCreditLimitAmount(
                safeDouble(firstPayload.getAmaah_crlm_am())
            );
            cm12IntradayTradeTotal_NP.setAmaCurrentAvailableAmount(
                safeDouble(firstPayload.getAmaah_cu_avl_am())
            );
            cm12IntradayTradeTotal_NP.setAmaDelayedDepositAmount(
                safeDouble(firstPayload.getAma_dly_dep_am())
            );
        });

    // Set values from CommonTechRuleResult
    cm12IntradayTradeTotal_NP.setBa53IntradayGBRCreditsCMA(
        safeDouble(commonTechRuleResult.getIntradayGbrCredits())
    );
    cm12IntradayTradeTotal_NP.setBa53IntradayGBRTotalPrimary(
        safeDouble(commonTechRuleResult.getIntradayGbrTotal())
    );
    cm12IntradayTradeTotal_NP.setBbaSpendingLimitAmount(
        safeDouble(commonTechRuleResult.getBa12AuthSpendingLmtAmt())
    );
    cm12IntradayTradeTotal_NP.setBbaSpendingLimitIndicator(
        String.valueOf(commonTechRuleResult.isWsAuthSpendingLmt())
    );

    // Handle multi-margin and non-multi-margin cases
    if (nonMultiMargin) {
        cm12IntradayTradeTotal_NP.setWorkIntradayNontradeTotal(
            safeDouble(commonTechRuleResult.getWsIntradayNonTradeTotal())
        );
    } else if (multiMargin) {
        cm12IntradayTradeTotal_NP.setWorkIntradayNontradeTotalMM(
            safeDouble(commonTechRuleResult.getWsIntradayNonTradeTotal())
        );
    }

    // Return the populated object
    return cm12IntradayTradeTotal_NP;
}
