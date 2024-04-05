package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberImporterImpl implements MemberImporter {

	@Override
	public List< Member > importMembers( File inputFile ) throws Exception {

		/*
		 * Implement the missing logic
		 */
		 List<Member> members = new ArrayList();

		try (BufferedReader br = new BufferedReader( new FileReader( inputFile ) )) {
			String line = br.readLine();
			
            while (line != null) {
            	
            	line = br.readLine();
            	
            	if(line != null) {
            		 members.add(parseMember(line));
            	}
                
            }
		}

		return members;
	}
	
	private Member parseMember(String line) {
        Member member = new Member();
        
        member.setId(line.substring(0, 12).trim());//dffhfdhfdjfgdjgfgdfdf
        member.setAddress(line.substring(62, 92).trim());
        member.setCity(line.substring(92, 112).trim());
        member.setFirstName(line.substring(37, 62).trim());
        member.setLastName(line.substring(12, 37).trim());
        member.setState(line.substring(112, 116).trim());
        member.setZip(line.substring(116).trim());
               
        return member;
              
    }

}
