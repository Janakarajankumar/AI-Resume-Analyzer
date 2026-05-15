package com.resume.backend.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeService {

    public String analyzeResume(MultipartFile file) throws IOException {

        String text = new String(file.getBytes()).toLowerCase();

        List<String> skills = new ArrayList<>();

        int score = 0;

        if (text.contains("java")) {
            skills.add("Java");
            score += 15;
        }

        if (text.contains("spring")) {
            skills.add("Spring Boot");
            score += 15;
        }

        if (text.contains("react")) {
            skills.add("React");
            score += 15;
        }

        if (text.contains("sql")) {
            skills.add("SQL");
            score += 10;
        }

        if (text.contains("html")) {
            skills.add("HTML");
            score += 10;
        }

        if (text.contains("css")) {
            skills.add("CSS");
            score += 10;
        }

        if (text.contains("javascript")) {
            skills.add("JavaScript");
            score += 15;
        }

        if (score > 100) {
            score = 100;
        }

        StringBuilder result = new StringBuilder();

        result.append("RESUME ANALYSIS\n\n");

        result.append("Resume Score: ")
              .append(score)
              .append("/100\n\n");

        result.append("Detected Skills:\n");

        if (skills.isEmpty()) {
            result.append("- No major technical skills detected\n");
        } else {
            for (String skill : skills) {
                result.append("- ").append(skill).append("\n");
            }
        }

        result.append("\nStrengths:\n");

        if (score >= 70) {
            result.append("- Good technical skillset\n");
            result.append("- Resume suitable for software roles\n");
        } else {
            result.append("- Resume has basic structure\n");
        }

        result.append("\nSuggestions:\n");

        if (!text.contains("project")) {
            result.append("- Add more projects\n");
        }

        if (!text.contains("internship")) {
            result.append("- Add internship experience\n");
        }

        if (!text.contains("github")) {
            result.append("- Add GitHub profile\n");
        }

        result.append("- Improve resume formatting\n");

        return result.toString();
    }
}