package tcbase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

@Controller
public class TcbaseController {
	
	 @Autowired
	    JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/greeting")
	 public String greeting(@RequestParam(value="name", required=false) String name, @RequestParam(value="type", required=false) String type,Model model) {
		List<Relation> results;
		Set<String> names = new HashSet<String>();
		Set<String> types = new HashSet<String>();
		if(name==null){name="";}
		if(type==null){type="";}
		if(name=="" && type==""){
			results = jdbcTemplate.query(
	                "select id, type, sentence, link, arg1type, arg1name, arg2type, arg2name from Relations",
	                new RelationRowMapper());
		}
		else if (name!="" && type==""){
			results = jdbcTemplate.query(
	                "select id, type, sentence, link, arg1type, arg1name, arg2type, arg2name from Relations where arg1name = ? or arg2name = ?", new Object[] { name, name},
	                new RelationRowMapper());
		}
		else if (name=="" && type!=""){
			results = jdbcTemplate.query(
	                "select id, type, sentence, link, arg1type, arg1name, arg2type, arg2name from Relations where type = ?", new Object[] { type },
	                new RelationRowMapper());
		}
		else{
			results = jdbcTemplate.query(
	                "select id, type, sentence, link, arg1type, arg1name, arg2type, arg2name from Relations where (arg1name = ? or arg2name = ?) and type = ? ", new Object[] { name, name, type },
	                new RelationRowMapper());
		}
		
		model.addAttribute("name", name);
		model.addAttribute("type", type);
		
		for(Relation result:results){
			names.add(result.getArg1name());
			names.add(result.getArg2name());
			types.add(result.getType());
		}
		
		
		model.addAttribute("relations", results);
		model.addAttribute("names", names);
		model.addAttribute("types", types);
		
		return "greeting";
		
   }

}

