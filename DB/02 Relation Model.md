# Data Model
데이터의 관계, 접근과 그 흐름에 필요한 처리 과정에 관한 추상화된 모형이다.

## 데이터 모델의 구성

- **Structure of the data**: 데이터의 구조
- **Operation on the data**: 데이터에 대한 작업
- **Constraints on the data**: 데이터에 대한 제약

## 데이터 모델의 종류

- **주요 모델**
    - **_The Relation Model_**: 관계형 모델
    - **The Semistructured-data Model including XML**: XML을 포함한 반구조적 모델

- **기타 모델**
    - **Object-oriented Data Model**: 객체지향 데이터 모델
    - **Object-relational Model**: 객체 관계형 모델
    - **Hierarchical Model**: 계층적 모델
    - **Network Model**: 네트워크 모델

---

# Relation Model

### Movies(Table)
| title | year | length | genre |
| --- | --- | --- | --- |
| Gone With the Wind | 1939 | 231 | drama |
| Star Wars | 1977 | 124 | sciFi |
| Wayne's World | 1992 | 95 | comedy |

- **속성(Columns)**
    - title, year, length, genre

- **Schemas**
    - Movies(title, year, length, genre)

- **Tuples**
    - (Gone With the Wind, 1939, 231, drama)

- **Domains**
    - Movies(title: string, year: integer, length: integer, genre: string)

## PRIMARY KEY & UNIQUE

### KEY

- 테이블에서 단 하나만 존재할 수 있는 특별한 종류의 `UNIQUE` 제약 조건입니다.
- 주 `KEY`로 지정된 열을 테이블의 각 행을 고유하게 식별하는 데 사용됩니다.
- **`NULL`** 값을 가질 수 없으며, 테이블 내에서 반드시 유일한 값을 가져야 합니다.
- 한 테이블에는 하나의 주 `KEY`만 있을 수 있습니다.
    - 하나의 열이거나 여러 열의 조합(복합 키)일 수 있습니다.

**Example (Movies)**
- {title}
- {title, year}
- {title, year, length}
- {title, year, length, genre}

1. 만약 `{title, year}`를 key로 사용하고자 한다면 schema로 다음과 같이 작성할 수 있습니다.
    - Movies( **title**, **year**, length, genre )

2. 자체적으로 숫자 키(**`id`**)를 만들어 사용할 수도 있습니다.
    - Movies( **id**, title, year, length, genre )

### UNIQUE

- 열에 **`UNIQUE`**제약 조건을 설정하면, 해당 열의 값을 테이블 내에서 중복될 수 없음을 의미합니다.
- **`UNIQUE`** 제약 조건이 있는 열은 **`NULL`** 값을 가질 수 있습니다. 
    - SQL 표준에 따르면, **`UNIQUE`** 제약 조건이 있는 열은 여러 개의 **`NULL`** 값을 가질 수 있습니다.
 - 한 테이블에 여러 개의 **`UNIQUE`** 제약 조건이 있을 수 있습니다. 
    - 여러 열이 각각 유일한 값을 가져야 함을 보장하지만, 각각의 열은 테이블의 주 키로 사용될 수는 없습니다.