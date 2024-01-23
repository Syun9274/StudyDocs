# 게시판 주요 기능
| 기능 | 주소 |
| --- | --- |
| 글 작성  | **`/board/save`** |
| 글 목록 | **`/board/`** |
| 글 조회 | **`/board/{id}`** |
| 글 수정 | **`/board/update/{id}`** |
| 글 삭제 | **`/board/delete/{id}`** |
| 페이징 처리 | **`/board/paging`** |

## 글 수정

- 상세화면에서 수정 버튼 클릭

- 서버에서 해당 게시글의 정보를 가지고 수정 화면 출력

- 제목, 내용 수정 입력 받아서 서버로 요청

- 수정 처리

## 페이징 처리

- **`/board/paging?page=2`**

- **`/board/paging/2`**

- 게시글 14
    - 한 페이지에 5개 씩 -> 3 페이지
    - 한 페이지에 3개 씩 -> 5 페이지

## 파일 첨부하기

- 단일 파일 첨부

- 다중 파일 첨부

- 파일 첨부와 관련하여 추가 될 부분들
    - **`save.html`**
    - **BoardDTO**
    - **`BoardService.save()`**
    - **BoardEntity**
    - **BoardFileEntity**, **BoardFileRepository** 추가
    - **`detail.html`**

- **board_table**(부모) - **board_file_table**(자식)

    ```sql
    create table board_table
    (
    id             bigint auto_increment primary key,
    created_time   datetime     null,
    updated_time   datetime     null,
    board_contents varchar(500) null,
    board_hits     int          null,
    board_pass     varchar(255) null,
    board_title    varchar(255) null,
    board_writer   varchar(20)  not null,
    file_attached  int          null
    );

    create table board_file_table
    (
    id                 bigint auto_increment primary key,
    created_time       datetime     null,
    updated_time       datetime     null,
    original_file_name varchar(255) null,
    stored_file_name   varchar(255) null,
    board_id           bigint       null,
    constraint FKcfxqly70ddd02xbou0jxgh4o3
        foreign key (board_id) references board_table (id) on delete cascade
    );
    ```