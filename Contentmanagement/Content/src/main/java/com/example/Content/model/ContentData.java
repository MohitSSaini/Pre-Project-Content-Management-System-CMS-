package com.example.Content.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentData {
    private int cid;
    private String title;
    private String description;
    private String  writer;
    private String topic;
}
