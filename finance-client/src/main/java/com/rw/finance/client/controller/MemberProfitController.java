package com.rw.finance.client.controller;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import com.rw.finance.client.annotation.Member;
import com.rw.finance.common.constants.MemberProfitConstants;
import com.rw.finance.common.entity.MemberProfit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rw.finance.client.vo.MemberProfitVo;
import com.rw.finance.common.constants.MemberInfoConstants;
import com.rw.finance.client.service.MemberProfitService;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.MathUtils;
import com.rw.finance.common.utils.Result;

/**
 * 
 * @file MemberProfitController.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午4:48:06
 * @declaration
 */
@RestController
@RequestMapping(value="/member/profit")
public class MemberProfitController {

	@Autowired
	private MemberProfitService memberProfitService;
	/**
	 * 根据用户编号和分润等级获取分润列表
	 * @param memberid 会员编号
	 * @param level 分润等级
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/listByMemberidAndLevel")
	public Result<Object> listByMemberidAndLevel(@RequestAttribute(value="memberid"  )long memberid,
			@RequestParam(value="level")int level,
			@RequestParam(value="page",required=false,defaultValue="0")int page,
			@RequestParam(value="size",required=false,defaultValue="100")int size){
		List<MemberProfit> memberProfits=memberProfitService.listByMemberidAndLevel(memberid, level,page,size);
		return new Result<Object>(200,null,memberProfits);
	}
	/**
	 * 获取会员收益列表
	 * @param memberid
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/listByMemberid")
	public Result<Object> listByMemberid(@RequestAttribute(value="memberid"  )long memberid,
			@RequestParam(value="page",required=false,defaultValue="0")int page,
			@RequestParam(value="size",required=false,defaultValue="100")int size){
		List<MemberProfit> memberProfits=memberProfitService.listByMemberid(memberid,page,size);
		return new Result<Object>(200,null,memberProfits);
	}
	/**
	 * 分组统计收益
	 * @param memberid
	 * @return
	 */
	@Member(level=MemberInfoConstants.Level.LEVEL_0)
	@PostMapping(value="/countByMemberidGroupLevel")
	public Result<Object> countByMemberidGroupLevel(@RequestAttribute(value="memberid"  )long memberid){
		List<Object[]> lists=memberProfitService.countByMemberidGroupLevel(memberid);
		MemberProfitVo.MemberProfitCountVo vo=new MemberProfitVo().new MemberProfitCountVo();
		Calendar calendar=Calendar.getInstance();
		double toDayProfit=memberProfitService.sumProfitByMemberidAndDate(memberid,DateUtils.getDateStr(calendar.getTime()));
		vo.setToDayProfit(toDayProfit);//今日收益
		calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)-1);
		double yesterDayProfit=memberProfitService.sumProfitByMemberidAndDate(memberid,DateUtils.getDateStr(calendar.getTime()));
		vo.setYesterDayProfit(yesterDayProfit);//昨日收益
		for(int i = MemberProfitConstants.Level.LEVEL1.getLevel(); i<=MemberProfitConstants.Level.LEVEL3.getLevel(); i++){
			Object[] objs=null;
			for(Object[] list:lists){//获取当前循环到的等级
				if(i==Integer.valueOf(list[0].toString())){
					objs=list;
				}
			}
			double levelProfit=StringUtils.isEmpty(objs)?0:(double)objs[1];
			double levelTotalBizAmount=StringUtils.isEmpty(objs)?0:(double)objs[2];
			BigInteger levelMemberCount=StringUtils.isEmpty(objs)?BigInteger.valueOf(0):(BigInteger)objs[3];
			MemberProfitVo.MemberProfitCountVo.ProfitLevel profitLevel=new MemberProfitVo().new MemberProfitCountVo().new ProfitLevel(levelProfit, levelTotalBizAmount, levelMemberCount.longValue());
			vo.getProfitLevels().add(profitLevel);
			vo.setTotalProfit(MathUtils.add(StringUtils.isEmpty(vo.getTotalProfit())?0:vo.getTotalProfit(),levelProfit));
		}
		return new Result<Object>(200,null,vo);
	}
	
}
