package br.com.heinzenberg.heinzenberg.controller;


import br.com.heinzenberg.heinzenberg.entities.*;

import br.com.heinzenberg.heinzenberg.repository.BrandRepository;
import br.com.heinzenberg.heinzenberg.repository.GoalRepository;
import br.com.heinzenberg.heinzenberg.repository.ProductRepository;
import br.com.heinzenberg.heinzenberg.repository.RegisterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {


    private final GoalRepository goalRepository;
    private final ProductRepository productRepository;

    private final BrandRepository brandRepository;

    private final RegisterRepository registerRepository;

    public RegisterController(GoalRepository goalRepository, ProductRepository productRepository, BrandRepository brandRepository, RegisterRepository registerRepository) {
        this.goalRepository = goalRepository;
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.registerRepository = registerRepository;
    }

    @PostMapping("/data")
    public void register(@RequestBody RegisterRequest registerRequest) {
        registerRepository.save(new Register(registerRequest));
    }

    @PostMapping("/goal")
    public void getGoal(@RequestBody GoalRequest goalRequest) {
        Goal goal = new Goal(goalRequest);
        goalRepository.saveGoal(goal);
    }

    @GetMapping("/goal/{id}")
    public Goal getGoal(@PathVariable String id) {
        return goalRepository.findById(id);
    }

    @GetMapping("/goal")
    public List<Goal> getGoal() {
        return goalRepository.findAll();
    }

    @GetMapping("/product")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) {
        return productRepository.findById(id);
    }

    @GetMapping("/brand")
    public List<Brand> getBrand() {
        return brandRepository.findAll();
    }

    @GetMapping("/brand/{id}")
    public Brand getBrandById(@PathVariable int id) {
        return brandRepository.findById(id);
    }

}
