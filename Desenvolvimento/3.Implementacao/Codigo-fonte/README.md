# AgendaAi

## Getting started
As dependencias e guias de instalacao estao listadas nos respectivos readmes.
Para trabalhar com os submodulos é necessario inicializar eles neste repositorio
```sh
git submodule update --init # Para a primeira vez usando
```

Abra o submodulo, faça as alterações em uma nova branch e então volte a root do projeto e:
```sh
git add relative_path_do_submodulo
git commit -m "build: Atualiza subrepo AgendaAi-APx"
git push
```

Uma boa prática é sempre que retornar a main ou trocar de branch, usar o comando:
```
git submodule update
```
Isso faz com que o submodulo atualize para uma versão compativel com a da branch atual.

## APP
Aplicacao web usando angular, typescript e saas para criacao de interfaces requests.

## API
Backend usando Java e Spring.

## Guias
Guia:
- https://gist.github.com/gitaarik/8735255
Documentações oficiais do git:
- https://git-scm.com/docs/git-submodule
- https://git-scm.com/book/en/v2/Git-Tools-Submodules
