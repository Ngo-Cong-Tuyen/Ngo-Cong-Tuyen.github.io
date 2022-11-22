package com.example.coron.feedback;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleFeedback {
     private boolean validate=true;
     private String message= "Successful Process!";
}
