
A Journal Entry (JE) request involving a margin account typically relates to the movement of cash or positions between a cash account and a margin account within a brokerage or trading system. Here’s a breakdown of what this entails:

Key Concepts
Margin Account

A brokerage account that allows investors to borrow funds to trade securities.
Uses securities and cash as collateral for borrowing.
Cash Account

A traditional account where trades are settled with available cash.
No leverage is used in this type of account.
Journal Entry (JE) Request

An internal transfer of assets (cash or securities) between accounts.
Typically used for bookkeeping and reconciliation.

Types of JE Transactions in a Margin Account
Moving Cash to Margin

A request to transfer funds from a cash account into a margin account.
This may be done to increase margin buying power or cover a margin call.
Example:
Transfer $10,000 from cash to the margin account to meet margin requirements.
Moving Margin Position to Cash

A request to settle a margin position by moving funds back to a cash account.
Often done when an investor wants to reduce leverage or withdraw cash.
Example:
After selling a margin position, the proceeds are moved to the cash account.




# Weather Informer

####  Weather Informer displays weather information by interacting with Open weather interface.

  - It takes city names as inputs with common separated values
  - It shows the weather information widget for each city.
  - Enabled i18n and default to English and french is also enabled (lang=ja)

## Getting Started

Please follow the below steps to setup and run weather-informer

### Prerequisites

- Weather Informer requires Java 8 need to be installed.
- Install any Java IDE (Eclipse, STS, Intellij etc..) and ensure you are able to launch
-  Clone/Checkout the project from version control system (git) and follow below steps

```
$ cd weather-informer
$ mvn clean install 
$ mvn tomcat7:run -e
$ Open web browser & hit the url: http://localhost:8080/weather/?lang=en
```
## Development Setup

- Clone weather-informer project. (git clone <repo url>)
- Open eclipse and import this project under (Existing Maven project)

## Tech stack

- Java 8
- jQuery
- Spring Web MVC
- Jsp


## Running the tests
```
$ cd <path/to/weather-informer>
$ mvn test -e
```
## Developer(s)

*  Anil Deshpande

## Acknowledgments

* [https://www.baeldung.com/spring-dispatcherservlet](https://www.baeldung.com/spring-dispatcherservlet)
* [https://www.journaldev.com/2610/spring-mvc-internationalization-i18n-and-localization-l10n-example](https://www.journaldev.com/2610/spring-mvc-internationalization-i18n-and-localization-l10n-example)
