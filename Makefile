#!/usr/bin/env zsh
SHELL := /bin/zsh

.DEFAULT: default
default: help

.PHONY: help
help: ## Shows the help screen
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

.PHONY: build
build: ## Build the application
	./gradlew build

.PHONY: run
run: ## Run the application
	./gradlew run

.PHONY: start
start: build run ## Run the application

.PHONY: scan
scan: ## Publish a Build Scan
	./gradlew build --scan
