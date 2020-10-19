package com.cts.MLEU.stockRestServices;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.MLEU.stockRestServices.Dao.StockDao;
import com.cts.MLEU.stockRestServices.Model.Stock;
import com.cts.MLEU.stockRestServices.Service.StockService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockTest {
	
	@MockBean
	StockDao stockDao;

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	StockService stockImpl;
	
	@Before
	public void init() {
		Stock stock = new Stock(1,"cts",150.25,150,new Date(2020-06-01));
		
		when(stockDao.findById(1)).thenReturn(Optional.of(stock));
	}

	@WithMockUser("USER")
	@Test
	public void testFindId() throws Exception{
		mockMvc.perform(get("/stock/getStocksById/1"))
		.andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.name", is("cts")))
        .andExpect(jsonPath("$.price", is(150.25)))
        .andExpect(jsonPath("$.volume", is(150)))
        .andExpect(jsonPath("$.date", is(new Date(2020-06-01))));
	}
	
	@WithMockUser("USER")
	@Test
	public void testFindName() throws Exception{
		mockMvc.perform(get("/stock/findByName/cts"))
		.andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.name", is("cts")))
        .andExpect(jsonPath("$.price", is(150.25)))
        .andExpect(jsonPath("$.volume", is(150)))
        .andExpect(jsonPath("$.date", is(new Date(2020-06-01))));
	}
	
	@WithMockUser("USER")
	@Test
    public void findAll() throws Exception {
        // given
        Stock stock = new Stock();
        stock.setId(1);
        stock.setName("Stock 1");
        stock.setPrice(150.0);
        stock.setVolume(120);
        stock.setDate(new Date(2020-05-05));
        
        List<Stock> stocks = Arrays.asList(stock);
        given(stockImpl.getAllStock()).willReturn(stocks);

        // when + then
        this.mockMvc.perform(get("/stock/getStocks"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().json("[{'id': 1,'name': 'Stock 1';'price': 150.0;'volume':120;'date':'2020-06-01'}]"));
    }
	
	@Test
	public void testStockDelete() throws Exception {
	    this.mockMvc.perform(MockMvcRequestBuilders
	            .delete("/stock/deleteById/1")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
}
