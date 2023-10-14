
<p align="center">
    <img src="https://bow-hair-db3.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F571a24a3-05f9-4ea5-b01f-cba1a3ac070d%2Fa864b64b-c5ad-4d82-b7bc-2bcabc892bbc%2Fhome.jpeg?table=block&id=1850bca2-6fda-4e0c-a141-0df270c03409&spaceId=571a24a3-05f9-4ea5-b01f-cba1a3ac070d&width=2000&userId=&cache=v2" width="250px">
</p>

# wanted-pre-onboarding-backend 

![Generic badge](https://img.shields.io/badge/pre_onboarding-assignment-green.svg)
![Generic badge](https://img.shields.io/badge/version-1.0.0-brightgreen.svg)

> 원티드 프리온보딩 백엔드 인턴십 선발과제, 기업의 채용을 위한 웹 서비스를 구현한 저장소입니다.


 <br>
<!--
<img src="./operation.gif">
-->

# 목차

- [시작하기](#시작하기)
- [기술 스택](#기술-스택)
- [요구사항 분석 및 구현](#요구사항-분석-및-구현)
- [테스트](#테스트)

<br>

## 시작하기
- 레포지토리를 clone 합니다.
```git
git clone https://github.com/12hyeon/wanted-pre-onboarding-backend
``` 
- IDE에서 application.properties 파일에서 연결할 MYSQL 정보로 수정하고, 애플리케이션을 실행합니다.

## 기술 스택

- 언어: Java
- 프레임워크: Spring
- 데이터베이스: MySQL

## API 명세서

<a href="https://drive.google.com/file/d/1RPdWWz4FS0PZxJJQwceqcAp70lwQGxdN/view?usp=sharing">swagger ui</a>

## 요구사항 분석 및 구현

1. 채용공고를 등록합니다.
   - 의도 : 회사별로 채용 공고 존재에 따른 회사 등로 후 채용공고 등록
   - api : 회사 등록, 채용공고 등록

<br>

2. 채용공고를 수정합니다.
   - 조건 : 회사 id 이외 모두 수정 가능합니다.
   - api : 채용공고 수정

<br>

3. 채용공고를 삭제합니다.
   - api : 채용공고 삭제

<br>

4. 채용공고 목록을 가져옵니다.
   1) 채용공고 목록
      - 의도 : 10개씩 공고를 n(>= 0)입력에 따라 페이지별 조회
      - api : 채용공고 전체 목록
      
   3) 채용공고 검색
      - 의도 : postingId에 따라 채용공고 + 같은 회사의 일부 공고 정보의 조회
      - api : 채용공고 상세 페이지 조회

<br>

5. 채용 상세 페이지를 가져옵니다.
   - 조건 : 채용내용이 추가적으로 담겨있으며, 해당 회사가 올린 다른 채용공고 가 추가적으로 포함됩니다.
   - 의도 : keyword가 title 또는 position가 포함된 공고를 페이지별로 조회
   - api : 채용공고 검색 목록

<br>

6. 사용자는 채용공고에 지원합니다.
   - 의도 : 한 사용자의 이력서를 다양한 곳에 지원할 수 있게 구성
   - api : 사용자 전체 목록, 사용자 등록(이력서), 지원자 등록

<br>

7. (추가) 지원자를 조회합니다.
   - 의도 : 회사별로 지원한 사용자 정보 조회
   - api : 지원자 전체 목록

---

## 테스트
- 채용 공고 수정, 삭제 : 등록되지 않은 회사 - 조회 불가능 예외 처리
- 채용 공고 저장 : 이미 등록된 사업자등록번호를 가진 회사 - 중복 예외 처리
- 사용자 지원 : 한 채용공고에 재지원 - 중복 예외 처리

이외는 로직의 동작을 확인하기 위해서 추가로 사용하였습니다.

 


---
