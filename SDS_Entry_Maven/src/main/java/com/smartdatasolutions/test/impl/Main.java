package com.smartdatasolutions.test.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter( ) {
		
		return new MemberExporterImpl();
	}

	@Override
	protected MemberImporter getMemberImporter( ) {
	
		 return new MemberImporterImpl();
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFile ) {
		List<Member> list = new ArrayList<>();
		Map<Member,Integer> map = new HashMap<>();
        for (Member member : membersFile) {
            if(!map.containsKey(member)) {
            	map.put(member, 1);
            	list.add(member);
            }
        }
        return list;
	}

	@Override
	protected Map<String,List<Member>> splitMembersByState(List<Member> validMembers){
	
		
		Map<String, List<Member>> map = new HashMap<>();
        for (Member member : validMembers) {
            String state = member.getState();
            if (!map.containsKey(state)) {
            	List<Member> list = new ArrayList<>();
            	list.add(member);
            	map.put(state, list);
            }else {
            	map.get(state).add(member);
            }
            
           
        }
        return map;
	}

	public static void main( String[] args ) {
//		 System.out.println("lin1");

		 try {
//			 System.out.println("lin2");
	            Main main = new Main();
//				 System.out.println("lin3");
	            File inputFileMember = new File(".\\Members.txt");
//				 System.out.println("lin4");
	            String outputFilePath = "target/output"; 
//				 System.out.println("lin5");
	            String outputFileName = "outputFile.csv"; 
//				 System.out.println("lin6");
	            main.convert(inputFileMember, outputFilePath, outputFileName);
//			    System.out.println("lin7");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
