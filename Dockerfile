FROM ubuntu:latest
LABEL authors="ivand"

ENTRYPOINT ["top", "-b"]