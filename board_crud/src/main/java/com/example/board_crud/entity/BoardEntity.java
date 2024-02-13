package com.example.board_crud.entity;

import com.example.board_crud.dto.BoardDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//DB의 테이블 역할을 하는 클래스
@Entity
@Getter
@Setter
@Table(name = "board_table")
public class BoardEntity extends BaseEntity {
    @Id //pk 컬럼 지정. 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long id;

    @Column(length = 20, nullable = false) // 크기 20, not null
    private String boardWriter;

    @Column //크기 255, null 가능
    private String boardPass;

    @Column private String boardTitle;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits;

    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    public static BoardEntity toEntity(BoardDTO boardDTO, BoardEntity boardEntity) {
        // Initialize entity if null, indicating a creation operation
        if (boardEntity == null) {
            boardEntity = new BoardEntity();
            // Set default values specific to new entities
            boardEntity.setBoardHits(0);
        } else {
            // update hits from DTO
            boardEntity.setBoardHits(boardDTO.getBoardHits());
        }
        // Common mapping logic
        boardEntity.setId(boardDTO.getId()); // Set ID if updating. This is harmless for creation as it should be null or ignored
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());

        return boardEntity;
    }
}
