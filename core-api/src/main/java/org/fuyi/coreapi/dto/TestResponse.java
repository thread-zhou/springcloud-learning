package org.fuyi.coreapi.dto;

import lombok.*;
import org.fuyi.common.api.BaseResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TestResponse extends BaseResponse {
    String data;
}
