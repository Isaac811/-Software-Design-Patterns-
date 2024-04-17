package com.work.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Jiayu Liu
 */
@Data
@Schema(title = "Add New User", description = "Add New User")
public class AddUserRQ {
    @Schema(name = "userName", description = "Account Number", format = "string", example = "Jiayu Liu")
    private String userName;
    @Schema(name = "password", description = "Password", format = "string", example = "123456")
    private String password;
}
