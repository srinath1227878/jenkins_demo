package in.sp.main.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.sp.main.Dto.AtmReqDto;
import in.sp.main.Dto.AtmRespDto;
import in.sp.main.Services.AtmService;

import java.util.List;

@RestController
public class AtmController {
	@Autowired
	AtmService  atmService;
	@PostMapping("/finalconfirm")
	public AtmRespDto finalConfirm(@RequestBody AtmReqDto atmReqDto) {
		return atmService.dtoToEntity(atmReqDto);
	}
	@GetMapping("/ticket-details/{email}")
	public ResponseEntity<List<AtmRespDto>> getTickets(@PathVariable String email){
		List<AtmRespDto> atmRespDtos = atmService.getData(email);
		return new ResponseEntity<>(atmRespDtos, HttpStatus.OK);
	}
}
