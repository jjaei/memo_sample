# memo_sample

## Spring framework란?
- Framework : 프레임워크라는 단어는 Frame(틀) + work(일)이라는 단어의 합성어로 **어떠한 일을 처리하기 위한 구조**를 제공한다.
- 프레임워크로 개발할 경우 전체 동작 방식은 프레임워크가 제공하고 개발자는 프레임워크의 일정 부분만 개발한다.
- 프레임워크가 순차적으로 메시지를 해석하면 해석한 메시지를 가지고 어떤 응답을 줄 지만 개발한다. 이를 통해 불필요한 개발 과정을 줄이고 중요한 개발과정에 집중할 수 있다.


<br>
<br>

## IoC(Inverse of Control)
- HTTP 요청의 해석, 어떤 Controller(요청 처리기)에서 처리하는지는 SpringMVC에서 해주고 개발자는 그 이후 처리 과정만 개발한다.
- 전체 제어 로직을 개발자가 아닌 프레임워크가 하기 때문에 이 과정을 제어의 역전(Ioc)라고 한다.

<br>
<br>

## DI(Dependency Injection)
- Spring이 시작되면 가장 먼저 하는 일은 Spring의 기본 컴포넌트, 다른 라이브러리에서 정의한 컴포넌트, 개발자가 정의한 컴포넌트를 초기화 하는 과정을 거친다.
- 이 컴포넌트를 Bean이라고 부르며 초기화가 끝나면 해당 컴포넌트가 필요한 곳에 컴포넌트를 주입한다.

<br>
<br>

## Spring MVC
- 웹 어플리케이션 프레임워크는 HTTP를 통해 오는 요청을 처리하고 HTTP를 통해 응답을 주는 과정을 제공해주고, 데이터베이스를 연동할 수 있는 기능을 제공해주는 프레임워크를 의미한다.
- HTTP Message 해석, Database 연결 및 연결 Pool 관리, Transaction 기능 제공, 멀티 쓰레드를 이용한 요청 처리 등을 제공한다.
- Controller : AP를 개발하는 핵심 부분으로 URL에 따라 어떻게 요청할지를 정의한다.
- Service : Controller에서 요청이 들어오면 실제로 데이터를 처리하는 컴포넌트이다.
- Repository : 데이터베이스에 접근하는 컴포넌트로 데이터를 가져오고 쓰는 기능을 한다. Service가 여러 테이블의 데이터를 조합해서 응답한다면 Repository는 하나의 테이블에 대한 접근을 제공한다.
