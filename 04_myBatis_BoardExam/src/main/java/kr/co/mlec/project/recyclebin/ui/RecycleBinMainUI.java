package kr.co.mlec.project.recyclebin.ui;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import kr.co.mlec.project.common.db.MyAppSqlConfig;
import kr.co.mlec.project.login.ui.LoginBaseUI;
import kr.co.mlec.project.login.ui.LoginUI;
import kr.co.mlec.project.main.ui.MainUI;
import kr.co.mlec.project.repository.mapper.MailMapper;
import kr.co.mlec.project.repository.vo.Mail;
import kr.co.mlec.project.repository.vo.User;

public class RecycleBinMainUI {
	
	Scanner sc = new Scanner(System.in);
	
	RecycleBinBaseUI rui = null;
	MainUI mainUi = new MainUI();
	MailMapper mapper;	
	User user;
	
	public RecycleBinMainUI() {
		mapper = MyAppSqlConfig.getSqlSessionInstance().getMapper(MailMapper.class);
	}

	public void service(User user) {	
		LoginBaseUI ui =null;
		String loginUser = user.getId();
		LoginUI lu = new LoginUI();
		while(true) {			
			List<Mail> list = mapper.selectBinMail(loginUser);	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			System.out.println("휴지통 전체 확인을 선택 하셨습니다.");
			System.out.println("---------------------------------------------------------------------- ");
			System.out.println("고유번호\t확인여부\t\t보낸사람\t\t시간\t\t\t제목");
			System.out.println("---------------------------------------------------------------------- ");

			
			for(Mail m : list) {
				System.out.println(
						m.getMailNo()+"\t"+
						m.getReadYN()+"\t\t"+
						m.getSender()+"\t\t"+
						sdf.format(m.getRegDate())+"\t\t"+
						m.getTitle()
						);
			}//for end 
			
			switch(menu()) {
			case 1: rui = new RestoreMailUI(mapper,user); break;
			case 2: rui = new DeleteRecycleMailUI(mapper,user);break;
			case 3: rui = new ClearRecycleBinUI(mapper,user);break;
			case 4: lu.service(user);break;
			}
				rui.service();
		}
	}
	
	public int menu() {
		System.out.println("---------------------");
		System.out.println("1. 받은 편지함으로 이동 ");
		System.out.println("2. 영구삭제 ");
		System.out.println("3. 휴지통 전체 비우기 ");
		System.out.println("4. 이전메뉴");
		System.out.println("---------------------");
		System.out.print("선택 : ");
		return Integer.parseInt(sc.nextLine());
	}
	
}
