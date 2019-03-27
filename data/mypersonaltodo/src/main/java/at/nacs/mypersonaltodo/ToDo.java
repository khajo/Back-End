package at.nacs.mypersonaltodo;


import lombok.Data;

@Data
public class ToDo {
    private String id;
    private String title;
    private boolean done;
}
