package jp.co.planaria.favoriteanime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.planaria.favoriteanime.entity.Anime;
import jp.co.planaria.favoriteanime.service.AnimeService;

/**
 * アニメ画面を制御するコントローラー
 * @author tomariryuuta
 *
 */
@Controller  
public class AnimeContoroller {
	
	@Autowired
	AnimeService service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Anime>animes =service.getAnimeList();//検索
		
		//Anime tensura = new Anime(1, "転すら", "スライム");
		//Anime kimetsu = new Anime(2, "キメツの刃", "鬼出る");
		
		//animes.add(tensura);
		//animes.add(kimetsu);
		
		//thymeleafに渡す
		model.addAttribute("animes", animes);
		
		return "list";
	}
	
	@RequestMapping("/search")
	public String search(AnimeCondition condition, Model model) {
		List<Anime> animes = service.searchAnimeListByCondition(condition); //検索
		model.addAttribute("animes", animes); //thymeleafに渡す
		
		return "list";
	}

	
}
