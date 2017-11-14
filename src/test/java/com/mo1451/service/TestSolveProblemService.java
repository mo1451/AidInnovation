/**
 * 
 */
package com.mo1451.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mo1451.model.StcOperator;
import com.mo1451.model.Tech;

/**
 * @author 默1451
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml"})
public class TestSolveProblemService {

	@Resource
	private SolveProblemService solveProblemService;
	/**
	 * Test method for {@link com.mo1451.service.SolveProblemService#findStcOperator(int)}.
	 */
	@Test
	public void testGetStcOperator() {
		List<StcOperator> stcOperators = solveProblemService.findStcOperator(38);
		System.out.println(stcOperators.size());
	}

	@Test
	public void testFindtech() {
		List<Tech> techs = solveProblemService.findtech(1);
		System.out.println(techs.size());
	}
}
