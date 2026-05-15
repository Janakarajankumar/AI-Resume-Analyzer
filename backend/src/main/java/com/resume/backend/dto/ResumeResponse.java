package com.resume.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResumeResponse {

    private int score;

    private String summary;

    private List<String> strengths;

    private List<String> weaknesses;

    private List<String> missingSkills;

    private List<String> suggestions;
}