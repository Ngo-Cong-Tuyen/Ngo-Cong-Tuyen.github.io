package com.example.user;

import com.example.user.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UserApplicationTests {

	@Test
	void get_file_extenstion_test() {
		String fileExtension = Utils.getFileExtension("image01.png");
		System.out.println(fileExtension);

		String fileExtension1 = Utils.getFileExtension("image01.jpg");
		System.out.println(fileExtension1);

		assertThat(fileExtension).isEqualTo(("png"));
		assertThat(fileExtension1).isEqualTo(("jpg"));

	}

	@Test
	void check_file_extension_tesdt(){
		assertThat(Utils.checkFileExtension("png")).isEqualTo(true);
		assertThat(Utils.checkFileExtension("jpg")).isEqualTo(true);
		assertThat(Utils.checkFileExtension("jpeg")).isEqualTo(true);
		assertThat(Utils.checkFileExtension("gif")).isEqualTo(true);
		assertThat(Utils.checkFileExtension("webp")).isEqualTo(true);
	}
}
