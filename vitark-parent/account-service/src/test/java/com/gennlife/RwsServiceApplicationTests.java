/*
package com.gennlife;

import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.action.PdfAction;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Link;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RwsServiceApplicationTests {
	private MockMvc mockMvc;
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
	}
	@Test
	public void contextLoads() {
		try {
			MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/rws/getEnv").accept(MediaType.ALL))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andDo(MockMvcResultHandlers.print())
					.andReturn();
			System.out.println(mvcResult.getResponse().getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void pdfTest(){
		try {
			PdfWriter pdfWriter = new PdfWriter("D:\\aa.pdf");
			PdfDocument pdfDocument = new PdfDocument(pdfWriter);
			Document document = new Document(pdfDocument);
			document.add(new Paragraph("你好"));
			PdfDocument pdfDoc = new PdfDocument(new PdfWriter("d:\\Helloworld.pdf"));
			// 支持系统字体（支持中文）
			PdfFontFactory.registerSystemDirectories();
			PdfFont chinese = PdfFontFactory.createRegisteredFont("microsoft yahei", PdfEncodings.IDENTITY_H);

			// 文字
			Paragraph phrase = new Paragraph();
			phrase.setFont(chinese);
			phrase.add("雷猴啊");
			Link chunk = new Link("European Business Award!",
					PdfAction.createURI("http://www.baidu.com"));
			phrase.add(chunk);

			// 图片
//            Image img = new Image(ImageDataFactory.create("src/main/resources/img/magic.png"));
//            img.setFixedPosition(80, 560);//有传页数参数的方法

			// 表格
			Table table = new Table(new float[]{0f, 0f});
			table.setWidth(300);
			table.setBorder(new DashedBorder(Color.BLACK, 5));
			//table.setFixedPosition(300f,300f,300f);

			table.addCell(phrase);
			table.addCell(phrase);
			table.addCell(phrase);
			table.addCell(phrase);
			// The complete cell is a link:
			Cell cell = new Cell().add("我的 Help us win a European Business Award!").add("tttttt");
			cell.setFont(chinese);
			Cell cell1 = new Cell().add("我的 Help us win a European Business Award!");
			cell1.setFont(chinese);
			table.addCell(cell);
			table.addCell(cell1);
			BarcodeQRCode code = new BarcodeQRCode();
			document.add(table);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
*/
