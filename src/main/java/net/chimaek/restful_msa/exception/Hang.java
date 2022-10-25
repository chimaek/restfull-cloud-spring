package net.chimaek.restful_msa.exception;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hang {

  private LocalDateTime  localDateTime;
  private String message;
  private String details;
}
